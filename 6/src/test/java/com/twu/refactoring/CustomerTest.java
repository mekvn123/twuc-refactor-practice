package com.twu.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CustomerTest {


	private static final String GOLD_PATH = "data/";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");


	private RegularMovie python =new RegularMovie("Monty Python and the Holy Grail");
	private RegularMovie ran =new RegularMovie("Ran");
	private NewReleaseMovie la =new NewReleaseMovie("LA Confidential");
	private NewReleaseMovie trek=new NewReleaseMovie("Star Trek 13.2");
	private ChildrenMovie wallace=new ChildrenMovie("Wallace and Gromit");

    @BeforeEach
    public void setUpData(){
       dinsdale.addRental(new Rental (python, 3));
       dinsdale.addRental(new Rental (ran, 1));
       dinsdale.addRental(new Rental (la, 2));
       dinsdale.addRental(new Rental (trek, 1));
       dinsdale.addRental(new Rental (wallace, 6));
   }

    @Test
    public void shouldOutputEmptyStatement() throws Exception {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty");
    }

    @Test
    public void shouldOutputCustomerStatement() throws Exception {
        verifyOutput(dinsdale.statement(), "output1");
    }

    @Test
    public void should_Output_Changed_Statement() throws Exception {
        RegularMovie regularLa = new RegularMovie(la.getTitle());

        dinsdale.replaceRental(dinsdale.getRental(2),new Rental(regularLa,2));

        verifyOutput(dinsdale.statement(), "outputChange");
    }

    /*
    public void testHtml() throws Exception {
        verifyOutput("1st Output", "outputHtml", dinsdale.htmlStatement());
    }
    */

    protected void verifyOutput(String actualValue, String fileName) throws IOException{
        String filePath = getClass().getClassLoader().getResource(GOLD_PATH + fileName).getPath();
        BufferedReader file = new BufferedReader (new FileReader (filePath));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        while  ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

}
