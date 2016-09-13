package edu.csumb.cst438fa16.QuestionsAnswers.rest;


import edu.csumb.cst438fa16.QuestionsAnswers.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Hangman REST service.
 *
 * See:
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("")
public class QuestionsAnswersResource {
	
	QuestionsAnswers questionAns = new QuestionsAnswers();
	
	
	//created the 3 Q's and A's in QsAsResource constructor
	public QuestionsAnswersResource()
	{
		questionAns.put("who is darth vader?","anakin");
		questionAns.put("is the sky blue?","yes"); 
		questionAns.put("is the grass always greener on the otherside?","no"); 
	}
	
	
	
	
	@GET
	@Path("/randomquestion")
	
	public String randQuestion()
	{
		return questionAns.getRandomQuestion();
	}
	
	@GET
    @Path("/testanswer")
	
	public Response testAnswer(@QueryParam("question") String q, @QueryParam("answer") String a)
	{
		boolean c = questionAns.testAnswer(q, a);
		
		if(c)
		{
			return Response.ok("'" + a + "' is the correct answer to '" + q + "'").build();
		}
	
			return Response.status(Response.Status.BAD_REQUEST)
	                   .entity(a + " is not the correct answer to " + q).build();

	}
}
