package me;
import java.util.*;
import java.io.*;

public class AcademicJournal {

    public AcademicJournal() {}

    public static String[] rankByImpact(String[] data) {
        Map<String, Journal> journals = new HashMap<String, Journal>();
        Paper[] papers = new Paper[data.length];
        int k = 0;
        for (String s : data) {
            String[] parts = s.split("\\.");
            int[] cit = new int[0];
            if (parts.length == 2) {
                String[] citations = parts[1].substring(1).split(" ");
                cit = new int[citations.length];
                for (int i = 0; i < cit.length; i++) {
                    cit[i] = Integer.parseInt(citations[i]);
                }
            }
            if (!journals.containsKey(parts[0])) {
                journals.put(parts[0], new Journal(parts[0]));
            }
            Journal j = journals.get(parts[0]);
            Paper p = new Paper(j, cit);
            papers[k] = p;
            k++;
            j.papers.add(p);
        }
        for (Paper p : papers) {
            Set<Paper> refs = new HashSet<Paper>();
            for (int i : p.citations) {
                if (!p.journal.equals(papers[i].journal)) {
                    refs.add(papers[i]);
                }
            }
            for (Paper pa : refs) pa.journal.citations++;
        }
        List<Journal> sortedJournals = new ArrayList<Journal>(journals.values());
        Collections.sort(sortedJournals, new Comparator<Journal>() {
                public int compare(Journal t, Journal o) {
                    double thisfactor = ((double)t.citations)/t.papers.size();
                    double otherfactor = ((double)o.citations)/o.papers.size();
                    int factorCompare = -Double.compare(thisfactor, otherfactor);
                    int sizeCompare = -Integer.compare(t.papers.size(), o.papers.size());
                    int nameCompare = t.name.compareTo(o.name);
                    return (factorCompare != 0 ? factorCompare :
                            (sizeCompare != 0 ? sizeCompare : nameCompare));
                }
            });
        List<String> re = new ArrayList<String>();
        for (Journal j : sortedJournals) {
            re.add(j.name);
        }
        return re.toArray(new String[0]);
    }
}


class Journal {
    String name;
    int citations;
    List<Paper> papers = new ArrayList<Paper>();

    Journal(String name) {
        this.name = name;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
             return false;
        }
        return name.equals(((Journal)other).name);
    }
}

class Paper {
    Journal journal;
    int[] citations;

    Paper(Journal journal, int[] citations) {
        this.journal = journal;
        this.citations = citations;
    }
}
