package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class Project {
    @SerializedName(value = "name")
    @JsonProperty("name")
    private String projectName;

    //@Expose
    private String announcement;

    @SerializedName(value = "show_announcement")
    @JsonProperty("show_announcement")
    private boolean flag;

    @SerializedName(value = "suite_mode")
    @JsonProperty("suite_mode")
    private int projectType;
}
