package zag.sm.post.model.enums;



public enum CommentReactions {

    LIKE("LIKE"),

    DIS_LIKE("DIS_LIKE");

    private String value;

    CommentReactions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CommentReactions{" +
                "value='" + value + '\'' +
                '}';
    }

}
