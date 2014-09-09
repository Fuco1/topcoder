package me;

import org.junit.*;
import static org.junit.Assert.*;

public class MooresLawTest {

    public MooresLawTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(6.2044816339207705, MooresLaw.shortestComputationTime(14), 1/1e9);
        assertEquals(2.870893001916099, MooresLaw.shortestComputationTime(3), 1/1e9);
        assertEquals(8.82533252835082, MooresLaw.shortestComputationTime(47), 1/1e9);
        assertEquals(10.907221008843223, MooresLaw.shortestComputationTime(123), 1/1e9);
        assertEquals(1.0, MooresLaw.shortestComputationTime(1), 1/1e9);
        assertEquals(2.0, MooresLaw.shortestComputationTime(2), 1/1e9);
        assertEquals(3.4934492508343644, MooresLaw.shortestComputationTime(4), 1/1e9);
        assertEquals(3.976341393165408, MooresLaw.shortestComputationTime(5), 1/1e9);
        assertEquals(6.3537851442471425, MooresLaw.shortestComputationTime(15), 1/1e9);
        assertEquals(7.278792184919884, MooresLaw.shortestComputationTime(23), 1/1e9);
        assertEquals(8.307629299277789, MooresLaw.shortestComputationTime(37), 1/1e9);
        assertEquals(9.317413824877127, MooresLaw.shortestComputationTime(59), 1/1e9);
        assertEquals(11.263312885856767, MooresLaw.shortestComputationTime(145), 1/1e9);
        assertEquals(11.63284638288751, MooresLaw.shortestComputationTime(172), 1/1e9);
        assertEquals(14.255837774585384, MooresLaw.shortestComputationTime(578), 1/1e9);
        assertEquals(14.937484180953778, MooresLaw.shortestComputationTime(792), 1/1e9);
        assertEquals(17.282813079502382, MooresLaw.shortestComputationTime(2341), 1/1e9);
        assertEquals(19.938064289282256, MooresLaw.shortestComputationTime(7985), 1/1e9);
        assertEquals(22.145489315993384, MooresLaw.shortestComputationTime(22145), 1/1e9);
        assertEquals(21.895384877438623, MooresLaw.shortestComputationTime(19728), 1/1e9);
        assertEquals(24.77000685648385, MooresLaw.shortestComputationTime(74470), 1/1e9);
        assertEquals(26.065317298034948, MooresLaw.shortestComputationTime(135498), 1/1e9);
        assertEquals(29.29896233651874, MooresLaw.shortestComputationTime(603785), 1/1e9);
        assertEquals(32.414680152491634, MooresLaw.shortestComputationTime(2547800), 1/1e9);
        assertEquals(33.87369424715167, MooresLaw.shortestComputationTime(5000000), 1/1e9);
        assertEquals(35.82970335003532, MooresLaw.shortestComputationTime(12345678), 1/1e9);
        assertEquals(40.0714320647176, MooresLaw.shortestComputationTime(87654321), 1/1e9);
        assertEquals(40.812595650125076, MooresLaw.shortestComputationTime(123456789), 1/1e9);
        assertEquals(43.643878310398875, MooresLaw.shortestComputationTime(456789012), 1/1e9);
        assertEquals(45.14042472529701, MooresLaw.shortestComputationTime(912121212), 1/1e9);
        assertEquals(45.322390118570624, MooresLaw.shortestComputationTime(992134572), 1/1e9);
        assertEquals(45.33928886681244, MooresLaw.shortestComputationTime(999912360), 1/1e9);
        assertEquals(45.339459031538375, MooresLaw.shortestComputationTime(999990989), 1/1e9);
        assertEquals(45.3394784171195, MooresLaw.shortestComputationTime(999999947), 1/1e9);
        assertEquals(45.339478525321624, MooresLaw.shortestComputationTime(999999997), 1/1e9);
        assertEquals(45.33947852748567, MooresLaw.shortestComputationTime(999999998), 1/1e9);
        assertEquals(45.33947852964971, MooresLaw.shortestComputationTime(999999999), 1/1e9);
        assertEquals(45.339478531813754, MooresLaw.shortestComputationTime(1000000000), 1/1e9);
        assertEquals(45.339478531813754, MooresLaw.shortestComputationTime(1000000000), 1/1e9);
        assertEquals(1.0, MooresLaw.shortestComputationTime(1), 1/1e9);
        assertEquals(45.33947852964971, MooresLaw.shortestComputationTime(999999999), 1/1e9);
        assertEquals(2.0, MooresLaw.shortestComputationTime(2), 1/1e9);
        assertEquals(45.339478525321624, MooresLaw.shortestComputationTime(999999997), 1/1e9);
        assertEquals(6.2044816339207705, MooresLaw.shortestComputationTime(14), 1/1e9);
    }
}
