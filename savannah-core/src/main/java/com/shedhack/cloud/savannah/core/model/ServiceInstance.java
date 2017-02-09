package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public interface ServiceInstance extends Serializable {

    // -------------
    // Field methods
    //--------------

    String getId();

    void setId(String id);

    Set<? extends Api> getApis();

    void setApis(Set<? extends Api> apiVersions);

    void addApi(Api apiVersion);

    String getArtifactVersion();

    void setArtifactVersion(String version);

    Date getDateTime();

    void setDateTime(Date date);

    Profile getProfile();

    void setProfile(Profile profile);

    String getUrl();

    void setUrl(String url);

    String getContainerImage();

    void setContainerImage(String containerImage);

    String getBuildJob();

    void setBuildJob(String ci);

    String getBuildNo();

    void setBuildNo(String ci);

    // -----------------------------------
    // Service Instance Dependency methods
    //------------------------------------

    Set<? extends Dependency> getDependencies();

    void setDependencies(Set<? extends Dependency> dependencies);

    void addDependency(Dependency dependency);

}
