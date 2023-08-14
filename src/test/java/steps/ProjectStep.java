package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void AddProject(Project project) {
        addProjectPage.openPageByUrl();

        addProjectPage.getNameInput().sendKeys(project.getProjectName());
        addProjectPage.getAnnouncementTextArea().sendKeys(project.getAnnouncement());

        addProjectPage.getShowAnnouncement().setFlag(project.isFlag());
        addProjectPage.getProjectType().selectByIndex(project.getProjectType());
        addProjectPage.getProjectType().selectByText("Use multiple test suites to manage cases");
        addProjectPage.getProjectType().selectByValue("1");
    }
}
