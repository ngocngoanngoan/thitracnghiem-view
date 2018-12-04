package grouptwo.quizexam.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Question;


public class QuestionService extends BaseService {

	public QuestionService() {
		super();
	}
	public static List<Question> getAllQuestions() {
		String query = "Select * from onlinequiz.questions";

		try {
			List<Question> lstQuestions = new ArrayList<>();

			ResultSet rs = excuteQuery(query);
			
			while (rs.next()) {
				Question questions = new Question(
						rs.getInt("Id"),
						rs.getString("Question"),
						rs.getString("Image"),
						rs.getString("Level"),
						rs.getInt("Subject"),
						rs.getInt("Creator"),
						rs.getInt("CorrectAnswer"));
				lstQuestions.add(questions);
				
			}
			return lstQuestions;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static List<Question> getAllQuestions(int firstReSult,int amoutResult) {
		String query = "select * from questions order by Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(firstReSult);
		param.add(amoutResult);
		List<Question> lstQuestions = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Question questions = new Question(
						rs.getInt("Id"),
						rs.getString("Question"),
						rs.getString("Image"),
						rs.getString("Level"),
						rs.getInt("Subject"),
						rs.getInt("Creator"),
						rs.getInt("CorrectAnswer"));
				lstQuestions.add(questions);
			}
			return lstQuestions;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	
	}
	public static List<Question> searchQuestion(String character)
	{
		String sql="SELECT * FROM questions " + 
				"WHERE lower(Question) LIKE ?";
		
		List<Question> lstQuestions = new ArrayList<>();
		try {
			ResultSet rs = searchExcuteQuery(sql,character);
			while (rs.next()) {
				Question questions = new Question(
						rs.getInt("Id"),
						rs.getString("Question"),
						rs.getString("Image"),
						rs.getString("Level"),
						rs.getInt("Subject"),
						rs.getInt("Creator"),
						rs.getInt("CorrectAnswer"));
				lstQuestions.add(questions);
			}
			return lstQuestions;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	public static int countQuestion()
	{
		String sql="select count(id) from questions";
		try
		{
			ResultSet rs=excuteQuery(sql);
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static Question getQuestionsById(int id) {
		String query = "Select * from onlinequiz.questions where Id = " +id;
		try
		{
			ResultSet rs = excuteQuery(query);
			rs.next();
			Question question = new Question(
					rs.getInt("Id"),
					rs.getString("Question"),
					rs.getString("Image"),
					rs.getString("Level"),
					rs.getInt("Subject"),					
					rs.getInt("Creator"),
					rs.getInt("CorrectAnswer"));
			return question;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static Question getQuestionsByName(String question) {
		String query = "Select * from onlinequiz.questions where Question = " +question;
		try
		{
			ResultSet rs = excuteQuery(query);
			Question questions = new Question(
					rs.getInt("Id"),
					rs.getString("Question"),
					rs.getString("Image"),
					rs.getString("Level"),
					rs.getInt("Subject"),
					rs.getInt("Creator"),
					rs.getInt("CorrectAnswer"));
			return questions;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static boolean deleteQuestions(int id) {
		String query="Delete from questions where Id=?";
		List<Object> params= new ArrayList<>();
		params.add(id);
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateQuestions(Question question) {
		{
			String query ="update questions set "
					+ "Question = ?,"
					+ "Image = ?,"
					+ "Level = ?,"
					+ "Creator = ?,"
					+ "CorrectAnswer = ?,"
					+ "Subject = ?,"
					+ "Where Id= ?";
			List<Object> params= new ArrayList<>();
			params.add(question.getQuestion());
			params.add(question.getImage());
			params.add(question.getLevel());
			params.add(question.getCreatorID());
			params.add(question.getCorrectAnswerID());
			params.add(question.getSubjectID());
			params.add(question.getQuestionId());
			try {
				boolean action = executeUpdate(query, params);
				return action;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	public static boolean addQuestions(Question question) {
		String query = "Insert into questions (Question,Image,Level,Creator,Subject)" + "values (?,?,?,?,?)";
		List<Object> params = new ArrayList<>();

		params.add(question.getQuestion());
		params.add(null);
		params.add(question.getLevel());
		params.add(null);
		params.add(question.getSubjectID());
		for (Object c : params) {
			System.out.println(c + "");
		}
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean updateCorrectAnswer(int questionId, int answerId) {
		String query = "update onlinequiz.questions set CorrectAnswer= ? where Id = ?";
		List<Object> params = new ArrayList<>();
		params.add(answerId);
		params.add(questionId);
		try {
			
			return executeUpdate(query, params);
		} catch (SQLException e) {
			
		}
		return false;

	}	
	
	public static List<Question> getRandQuestionByLevel(String level, int amount	) {
		String query = "Select * from onlinequiz.questions where level = "+level+" order by rand() limit " +amount;
		try {
			List<Question> lstQuestion = new ArrayList<>();
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Question question = new Question(
						rs.getInt("Id"),
						rs.getString("Question"), 
						rs.getString("Image"), 
						rs.getString("Level"), 
						rs.getInt("Creator"), 
						rs.getInt("CorrectAnswer"), 
						rs.getInt("Subject"));
				lstQuestion.add(question);
			}
			return lstQuestion;
			
		} catch (SQLException e) {
			
		}
		return null;

	}	
}


