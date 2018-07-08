package lu.cgi.sample.netflix.service.demo.bean;

public class DemoResponse {

    private DemoStatus status;
    private String comment;

    public DemoResponse() {
        super();
    }

    public DemoResponse(DemoStatus status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    public DemoStatus getStatus() {

        return status;
    }

    public void setStatus(DemoStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
