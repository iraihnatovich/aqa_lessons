package models;

import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    private boolean isAnnouncementShown;
    private int projectType;
    private boolean isApprovalEnabled;

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public boolean isAnnouncementShown() {
        return isAnnouncementShown;
    }

    public int getProjectType() {
        return projectType;
    }

    public boolean isApprovalEnabled() {
        return isApprovalEnabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public void setIsAnnouncementShown(boolean isAnnouncementShown) {
        this.isAnnouncementShown = isAnnouncementShown;
    }

    public void setProjectType(int projectType) {
       this.projectType = projectType;
    }

    public void setIsApprovalEnabled(boolean isApprovalEnabled) {
       this.isApprovalEnabled = isApprovalEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isAnnouncementShown == project.isAnnouncementShown && projectType == project.projectType && isApprovalEnabled == project.isApprovalEnabled && Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isAnnouncementShown, projectType, isApprovalEnabled);
    }


    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", projectType=" + projectType +
                '}';
    }
}
