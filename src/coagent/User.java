/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

/**
 *
 * @author Robert Korpics
 */
class User {
    private int Books_Id;
    private int Agent_Agent_Id;
    private int Authors_Authors_Id;
    private String Books_Title, Books_Genre, Books_Tag;
    
    public User(int Books_ID, int Agent_Agent_Id, int Authors_Authors_Id, String Books_Title, String Books_Genre, String Books_Tag)
    {
        this.Books_Id=Books_Id;
        this.Agent_Agent_Id=Agent_Agent_Id;
        this.Authors_Authors_Id=Authors_Authors_Id;
        this.Books_Title=Books_Title;
        this.Books_Genre=Books_Genre;
        this.Books_Tag=Books_Tag;
    }
    public int getBooks_Id(){
        return Books_Id;     
    }
    public int getAgent_Agent_Id(){
        return Agent_Agent_Id;
    }
    public int getAuthors_Authors_Id(){
        return Authors_Authors_Id;
    }
    public String getBooks_Title(){
        return Books_Title;
    }
    public String getBooks_Genre(){
        return Books_Genre;
    }
    public String getBooks_Tag(){
        return Books_Tag;
    }
}
