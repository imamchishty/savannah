package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.Map;

public interface ServiceInstance extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    void setId(String id);

    Set<ApiVersion> getApiVersions();

    void setApiVersions(Set<ApiVersion> apiVersions);

    void addApiVersion(ApiVersion apiVersion);

    Set<ServiceInstanceDependency> getDependencies();

    void setDependencies(Set<ServiceInstanceDependency> dependencies);

    void addDependency(ServiceInstanceDependency dependency);

    String getVersion();

    void setVersion(String version);

    String getScmRevision();

    void setScmRevision(String scmRevision);

    Date getDateTime();

    void setDateTime(Date date);

    Profile getProfile();

    void setProfile(Profile profile);

    String getStatus();

    void setStatus(String status);

    String getExecutor();

    void setExecutor(String executor);

    String getHost();

    void setHost(String host);

    int getPort();

    void setPort(int port);

    String getContainerImage();

    void setContainerImage(String containerImage);

    String getBuildJob();

    void setBuildJob(String ci);

    String getBuildNo();

    void setBuildNo(String ci);

    void setMetadata(Map<String, Object> map);

    void addMetadata(String key, Object value);

    Map<String, Object> getMetadata();
}
