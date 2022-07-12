package kz.bitlab.javapro.db;

import kz.bitlab.javapro.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javapro_db","postgres", "postgres");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User getUser(String email){

        User user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, full_name) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBlog(Blog blog){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO blogs (user_id, title, content, postdate) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, blog.getUser().getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContent());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Blog> getAllBlogs(){
        ArrayList<Blog> blogs = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.postdate, b.user_id, u.full_name, u.email " +
                    "FROM blogs b " +
                    "INNER JOIN users u ON u.id = b.user_id " +
                    "ORDER BY b.postdate DESC ");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                Blog blog = new Blog();
                blog.setContent(resultSet.getString("content"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostDate(resultSet.getTimestamp("postdate"));
                blog.setId(resultSet.getLong("id"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));

                blog.setUser(user);
                blogs.add(blog);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blogs;
    }

    public static Blog getBlog(Long id){
        Blog blog = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.postdate, b.user_id, u.full_name, u.email " +
                    "FROM blogs b " +
                    "INNER JOIN users u ON u.id = b.user_id " +
                    "WHERE b.id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                blog = new Blog();
                blog.setContent(resultSet.getString("content"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostDate(resultSet.getTimestamp("postdate"));
                blog.setId(resultSet.getLong("id"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));

                blog.setUser(user);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }

    public static void addComment(Comment comment){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (user_id, blog_id, comment, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getBlog().getId());
            statement.setString(3, comment.getComment());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Comment> getAllComments(Long blogId){

        ArrayList<Comment> comments = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.comment, c.user_id, c.blog_id, c.post_date, u.full_name " +
                    "FROM comments c " +
                    "INNER JOIN users u ON u.id = c.user_id " +
                    "WHERE c.blog_id = ? " +
                    "ORDER BY c.post_date DESC ");

            statement.setLong(1, blogId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getTimestamp("post_date"));

                Blog blog = new Blog();
                blog.setId(resultSet.getLong("blog_id"));
                comment.setBlog(blog);

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));

                comment.setUser(user);
                comments.add(comment);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return comments;

    }

}
