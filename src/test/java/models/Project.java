package models;

import java.util.Date;

public class Project {
    private String projectName;
    private String announcement;
    private boolean flag;
    private int projectType;
    private Date date;
    private Milestone milestone;

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }

        public Builder withProjectName(String projectName) {
            newProject.projectName = projectName;
            return this;
        }

        public Builder withAnnouncement(String announcement) {
            newProject.announcement = announcement;
            return this;
        }

        public Builder withFlag(boolean flag) {
            newProject.flag = flag;
            return this;
        }

        public Builder withProjectType(int projectType) {
            newProject.projectType = projectType;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }
}
