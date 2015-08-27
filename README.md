# symphony
An unofficial Java wrapper for the SearchLight Conductor APIs: http://developers.conductor.com/docs

### adding symphony to your project
symphony is hosted on <a href="http://search.maven.org/#artifactdetails%7Ccom.eveningsamurai.symphony%7Csymphony%7C0.2.4%7Cjar" target="_blank">maven central</a>
#### apache maven
```xml
<dependency>
    <groupId>com.eveningsamurai.symphony</groupId>
    <artifactId>symphony</artifactId>
    <version>0.2.4</version>
</dependency>
```
#### apache buildr
'com.eveningsamurai.symphony:symphony:jar:0.2.4'

#### apache ivy
```xml
<dependency org="com.eveningsamurai.symphony" name="symphony" rev="0.2.4" />
```

#### gradle
compile 'com.eveningsamurai.symphony:symphony:0.2.4'

### third party dependencies
symphony is a fat jar and contains the following dependencies

* gson
* guava

## usage examples
### initialization
```java
//access to the searchlight conductor requires an api key and a shared secret
SymphonyClient client = new SymphonyClient(apiKey, sharedSecret);
```
#### fetching account details
```java
//fetch the account associated with the api key and shared secret
AccountRequest req = client.accountInfo();
AccountResponse[] res = (AccountResponse[]) req.call();

System.out.println("Account Id: " + res[0].getAccountId());
```

#### fetching the rank source, device, location or category data
```java
//list of rank sources that the tracked searches will be associated with
RankSourceListRequest req = client.rankSourceList();
RankSourceListResponse[] list = (RankSourceListResponse[]) req.call();

System.out.println("Rank Source Description: " + list[0].getDescription());

//list of devices that the searches are tracked against
DeviceListRequest req = client.deviceList();
DeviceListResponse[] list = (DeviceListResponse[]) req.call();

System.out.println("Device List Description" + list[0].getDescription());

//list of locations used to identify the search origination 
LocationListRequest req = client.locationList();
LocationListResponse[] list = (LocationListResponse[]) req.call();

System.out.println("Location List Description" + list[0].getDescription());

//list of categories associated with each tracked search id
CategoryListRequest req = client.categoryList("MY_ACCOUNT_ID");
CategoryListResponse[] res = (CategoryListResponse[]) req.call();

System.out.println("Cateogory Name: " + res[0].getName());
```

#### getting the list of web properties associated with the account
```java
//list of web properties for the account
WebPropertyListRequest req = client.webProperties("MY_ACCOUNT_ID");
WebPropertyListResponse[] res = (WebPropertyListResponse[]) req.call();

System.out.println("Web Property URL: " + res[0].getName());
System.out.println("Search Engine Id: " + res[0].getRankSourceInfo()[0].getRankSourceId());
System.out.println("Comparison Web Property Name: " + res[0].getRankSourceInfo()[0].getComparisonWebProperties()[0].getName());
```

#### getting tracked search data
```java
//returns a list of all client web properties for the given account
SymphonyClient client = new SymphonyClient(apiKey, sharedSecret);
TrackedSearchListRequest req = client.trackedSearches("MY_ACCOUNT_ID", "MY_WEB_PROPERTY_ID");
TrackedSearchListResponse[] res = (TrackedSearchListResponse[]) req.call();

System.out.println("Tracked Search Id" + res[0].getTrackedSearchId());
System.out.println("Query Phrase" + res[0].getQueryPhrase());
```

#### getting web property rank data
```java
//report of all the result items of interest seen for all tracked searches on a particular client web property when measured against a particular rank source
ClientWebPropertyRankRequest req = client.webPropertyRanks("MY_ACCOUNT_ID", "MY_WEB_PROPERTY_ID", "MY_RANK_SOURCE_ID");
ClientWebPropertyRankResponse[] res = (ClientWebPropertyRankResponse[]) req.call();

System.out.println("Item Type: " + res[0].getItemType());
System.out.println("Search result URL: " + res[0].getTargetUrl());
System.out.println("Universal Rank: " + res[0].getRanks().getUniversalRank());
```

#### getting search volume information
```java
//report of monthly volumes seen for all tracked searches on  a particular client web property when measured against a particular rank source
ClientWebPropertyVolumeRequest req = client.webPropertyVolume("MY_ACCOUNT_ID", "MY_WEB_PROPERTY_ID", "MY_RANK_SOURCE_ID");
ClientWebPropertyVolumeResponse[] res = (ClientWebPropertyVolumeResponse[]) req.call();
		
System.out.println("Tracked Search Id: " + res[0].getTrackedSearchId());
System.out.println("Average volume of the tracked search id: " + res[0].getAverageVolume());
System.out.println("Month: " + res[0].getVolumeItems()[0].getMonth());
System.out.println("Volume for month: " + res[0].getVolumeItems()[0].getVolume());
```
