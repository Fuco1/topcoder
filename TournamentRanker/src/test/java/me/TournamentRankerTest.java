package me;

import org.junit.*;
import static org.junit.Assert.*;

public class TournamentRankerTest {

    public TournamentRankerTest() {}

    @Test
    public void test() throws Exception {
        assertArrayEquals(new String[]{"DUKE","XAVIER","ILLINOIS","TEXAS","SETONHALL","MISSISSIPPISTATE","CINCINNATI","NORTHCAROLINA"},
                          TournamentRanker.rankTeams(new String[]{"DUKE","SETONHALL","ILLINOIS","CINCINNATI","NORTHCAROLINA","TEXAS","XAVIER","MISSISSIPPISTATE"},
                                                     new String[]{"","DUKE","DUKE","ILLINOIS","TEXAS","XAVIER","DUKE","XAVIER"}));
        assertArrayEquals(new String[]{"C","N","S","I","J","DA","X","V","R","K","T","Y","Z","AA","FA","O","H","M","L","U","E","W","B","F","D","EA","BA","G","CA","A","Q","P"}, TournamentRanker.rankTeams(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","BA","CA","DA","EA","FA"}, new String[]{"AA","X","","R","J","V","Y","C","N","C","N","S","N","C","V","O","FA","C","C","S","I","I","DA","S","I","J","DA","T","Z","N","K","X"}));
    }
}
