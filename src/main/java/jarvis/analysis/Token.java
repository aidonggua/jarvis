package jarvis.analysis;

public class Token {

    private String lex;

    private String id ;

    private Integer position;

    private Integer line;

    public Token(String lex, String id, Integer position, Integer line) {
        this.lex = lex;
        this.id = id;
        this.position = position;
        this.line = line;
    }

    public String getLex() {
        return lex;
    }

    public void setLex(String lex) {
        this.lex = lex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}
