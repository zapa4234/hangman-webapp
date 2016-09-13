package edu.csumb.cst438fa16.QuestionsAnswers.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class QuestionsAnswersResourceTest extends JerseyTest {
  

    
    @Override
    protected Application configure() {
        return new ResourceConfig(QuestionsAnswersResource.class);
    }
    
    
    @Test
    public void testQuestions() {
        WebTarget webTarget = target("randomquestion");
        String thestart = webTarget.request().get(String.class);
        assertThat(thestart, anyOf(is("who is darth vader?"), is("is the sky blue?"), is("is the grass always greener?")));
    }
    
    //test if an answer is correct.
    @Test
    public void testAnswers() {
        WebTarget webTarget = target("testanswer").queryParam("answer", "maybe").queryParam("question", "is the sky blue?");
        Response response = webTarget.request().get();
        assertThat(response.getStatus(),
                equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }
    

    
    
    
    /*
    // setup() and teardown() are copied from
    // http://apmblog.dynatrace.com/2014/02/25/how-stable-are-your-unit-tests-best-practices-to-raise-test-automation-quality/
    // (which also suggests a better solution)
    private String oldWord;

    static private final String HANGMAN_WORD_PROPERTY_KEY =
        HangmanResource.HANGMAN_WORD_PROPERTY_KEY;

    @Before
    public void setup() {
        // setProperty returns the old value of the property
        oldWord = System.setProperty(HANGMAN_WORD_PROPERTY_KEY, WORD);
    }

    @After
    public void teardown() {
        if (oldWord == null) {
            System.clearProperty(HANGMAN_WORD_PROPERTY_KEY);
        } else {
            System.setProperty(HANGMAN_WORD_PROPERTY_KEY, oldWord);
        }
    }

    @Test
    public void testStart() {
        WebTarget webTarget = target("start");
        String thestart = webTarget.request().get(String.class);
        assertThat(thestart, equalTo("..."));
    }

    @Test
    public void testMatchWithoutParams() {
        WebTarget webTarget = target("match");
        Response response = webTarget.request().get();
        assertThat(response.getStatus(),
                   equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }

    @Test
    public void testMatchWithWrongOldPatternOldGuesses() {
        WebTarget webTarget = target("match").queryParam("oldPattern", ".a.")
                                             .queryParam("oldGuesses", "abc")
                                             .queryParam("newGuesses", "d");
        Response response = webTarget.request().get();
        assertThat(response.getStatus(),
                   equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
    }

    @Test
    public void testMatchWithCorrectOldPatternOldGuesses() {
        WebTarget webTarget = target("match").queryParam("oldPattern", "...")
                                             .queryParam("oldGuesses", "")
                                             .queryParam("newGuesses", "abc");
        String thematch = webTarget.request().get(String.class);
        assertThat(thematch, equalTo("ca."));
    }*/
}