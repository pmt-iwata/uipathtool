package jp.co.pmtech.iwata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UiPathTriggerDto {
    
    @JsonProperty("Enabled")
    private String enabled;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ReleaseId")
    private String releaseId;
    @JsonProperty("ReleaseKey")
    private String releaseKey;
    @JsonProperty("ReleaseName")
    private String releaseName;
    @JsonProperty("PackageName")
    private String packageName;
    @JsonProperty("EnvironmentName")
    private String environmentName;
    @JsonProperty("EnvironmentId")
    private String environmentId;
    @JsonProperty("JobPriority")
    private String jobPriority;
    @JsonProperty("RuntimeType")
    private String runtimeType;
    @JsonProperty("StartProcessCron")
    private String startProcessCron;
    @JsonProperty("StartProcessCronDetails")
    private String startProcessCronDetails;
    @JsonProperty("StartProcessCronSummary")
    private String startProcessCronSummary;
    @JsonProperty("StartProcessNextOccurrence")
    private String startProcessNextOccurrence;
    @JsonProperty("StartStrategy")
    private String startStrategy;
    @JsonProperty("StopProcessExpression")
    private String stopProcessExpression;
    @JsonProperty("StopStrategy")
    private String stopStrategy;
    @JsonProperty("ExternalJobKey")
    private String externalJobKey;
    @JsonProperty("TimeZoneId")
    private String timeZoneId;
    @JsonProperty("TimeZoneIana")
    private String timeZoneIana;
    @JsonProperty("UseCalendar")
    private String useCalendar;
    @JsonProperty("CalendarId")
    private String calendarId;
    @JsonProperty("CalendarName")
    private String calendarName;
    @JsonProperty("StopProcessDate")
    private String stopProcessDate;
    @JsonProperty("InputArguments")
    private String inputArguments;
    @JsonProperty("QueueDefinitionId")
    private String queueDefinitionId;
    @JsonProperty("QueueDefinitionName")
    private String queueDefinitionName;
    @JsonProperty("ItemsActivationThreshold")
    private String itemsActivationThreshold;
    @JsonProperty("ItemsPerJobActivationTarget")
    private String itemsPerJobActivationTarget;
    @JsonProperty("MaxJobsForActivation")
    private String maxJobsForActivation;
    @JsonProperty("Id")
    private String id;

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseKey() {
        return releaseKey;
    }

    public void setReleaseKey(String releaseKey) {
        this.releaseKey = releaseKey;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(String jobPriority) {
        this.jobPriority = jobPriority;
    }

    public String getRuntimeType() {
        return runtimeType;
    }

    public void setRuntimeType(String runtimeType) {
        this.runtimeType = runtimeType;
    }

    public String getStartProcessCron() {
        return startProcessCron;
    }

    public void setStartProcessCron(String startProcessCron) {
        this.startProcessCron = startProcessCron;
    }

    public String getStartProcessCronDetails() {
        return startProcessCronDetails;
    }

    public void setStartProcessCronDetails(String startProcessCronDetails) {
        this.startProcessCronDetails = startProcessCronDetails;
    }

    public String getStartProcessCronSummary() {
        return startProcessCronSummary;
    }

    public void setStartProcessCronSummary(String startProcessCronSummary) {
        this.startProcessCronSummary = startProcessCronSummary;
    }

    public String getStartProcessNextOccurrence() {
        return startProcessNextOccurrence;
    }

    public void setStartProcessNextOccurrence(String startProcessNextOccurrence) {
        this.startProcessNextOccurrence = startProcessNextOccurrence;
    }

    public String getStartStrategy() {
        return startStrategy;
    }

    public void setStartStrategy(String startStrategy) {
        this.startStrategy = startStrategy;
    }

    public String getStopProcessExpression() {
        return stopProcessExpression;
    }

    public void setStopProcessExpression(String stopProcessExpression) {
        this.stopProcessExpression = stopProcessExpression;
    }

    public String getStopStrategy() {
        return stopStrategy;
    }

    public void setStopStrategy(String stopStrategy) {
        this.stopStrategy = stopStrategy;
    }

    public String getExternalJobKey() {
        return externalJobKey;
    }

    public void setExternalJobKey(String externalJobKey) {
        this.externalJobKey = externalJobKey;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getTimeZoneIana() {
        return timeZoneIana;
    }

    public void setTimeZoneIana(String timeZoneIana) {
        this.timeZoneIana = timeZoneIana;
    }

    public String getUseCalendar() {
        return useCalendar;
    }

    public void setUseCalendar(String useCalendar) {
        this.useCalendar = useCalendar;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getStopProcessDate() {
        return stopProcessDate;
    }

    public void setStopProcessDate(String stopProcessDate) {
        this.stopProcessDate = stopProcessDate;
    }

    public String getInputArguments() {
        return inputArguments;
    }

    public void setInputArguments(String inputArguments) {
        this.inputArguments = inputArguments;
    }

    public String getQueueDefinitionId() {
        return queueDefinitionId;
    }

    public void setQueueDefinitionId(String queueDefinitionId) {
        this.queueDefinitionId = queueDefinitionId;
    }

    public String getQueueDefinitionName() {
        return queueDefinitionName;
    }

    public void setQueueDefinitionName(String queueDefinitionName) {
        this.queueDefinitionName = queueDefinitionName;
    }

    public String getItemsActivationThreshold() {
        return itemsActivationThreshold;
    }

    public void setItemsActivationThreshold(String itemsActivationThreshold) {
        this.itemsActivationThreshold = itemsActivationThreshold;
    }

    public String getItemsPerJobActivationTarget() {
        return itemsPerJobActivationTarget;
    }

    public void setItemsPerJobActivationTarget(String itemsPerJobActivationTarget) {
        this.itemsPerJobActivationTarget = itemsPerJobActivationTarget;
    }

    public String getMaxJobsForActivation() {
        return maxJobsForActivation;
    }

    public void setMaxJobsForActivation(String maxJobsForActivation) {
        this.maxJobsForActivation = maxJobsForActivation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
