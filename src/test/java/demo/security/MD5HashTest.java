package demo.security;

import static org.junit.Assert.*;

/**
 * Created by nasmajoh on 27.4.2016.
 */
public class MD5HashTest {
    MD5Hash md5hash;


    @org.junit.Before
    public void setUp() throws Exception {
        md5hash = new MD5Hash();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void calculate() throws Exception {
        String result = md5hash.calculate("kissa");
        assertEquals("md5 hash value ", "1ad99cbe9e425d4f19c53a29d4f12597", result );

    }

}