package lu.cgi.sample.netflix.service.demo.bean;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DemoRequest {


    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    private String name;

    @Range(min = 0, max = 3)
    private Integer deep;

    private Integer step=0;

    public DemoRequest() {
        super();
    }


    public DemoRequest(@NotNull @Size(max = 30) @Pattern(regexp = "[a-zA-Z0-9]") String name, @Range(min = 0, max = 3) Integer deep) {
        this.name = name;
        this.deep = deep;
    }

    public Integer getStep() {

        return step;
    }
    public void setStep(Integer step) {
        this.step = step;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public DemoRequest next() {
        DemoRequest demoRequest =new DemoRequest();
        demoRequest.setDeep(getDeep());
        demoRequest.setName(getName());
        demoRequest.setStep(getStep()+1);
        return demoRequest;
    }
}
