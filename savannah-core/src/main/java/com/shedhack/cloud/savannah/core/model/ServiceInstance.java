package com.shedhack.cloud.savannah.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface ServiceInstance extends Serializable {

    // ---------
    // Unique ID
    // ---------
    String getId();

    String getName();

    void setName(String name);

    Service getService();

    void setService(Service service);

    List<? extends ApiVersion> getApiVersions();

    void setApiVersions(List<? extends ApiVersion> apiVersions);

    List<? extends ServiceInstanceDependency> getDependencies();

    void setDependencies(List<? extends ServiceInstanceDependency> dependencies);

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

}
