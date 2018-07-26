/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vaio1
 */
public class Document_ParserTest {
    
    public Document_ParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parseFiles method, of class Document_Parser.
     */
    @org.junit.Test
    public void testParseFiles() throws Exception {
        System.out.println("parseFiles");
        File f = null;
        int docId = 0;
        Document_Parser instance = new Document_Parser();
        instance.parseFiles(f, docId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
