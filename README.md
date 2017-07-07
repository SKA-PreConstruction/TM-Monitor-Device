# TM-Monitor-Device
The TM Monitor device realize a bridge between the Software System Monitor (Nagios core in this example) and the tango hierarchy (developed with the help of the tango controls framework). It gathers information from the SSM and report it to any device server that subscribe to its attributes.

There are many integration possibilities based on the technological choice made for the software system monitor. Taking as SSM Nagios core, the solutions are:
* Read internal files that Nagios keep updated (i.e. status.dat),
* NDO, export current and historical data from one or more Nagios instances to a MySQL database,
* Nagios Event Broker API,
* Json CGI,
* Extending the core.

In this device the bridge is implemented with the JSON CGI. The Tango framework gives the possibility to add a dynamic list of attributes. This device foresee the a setting file in order to add those attributes in the initDevice method. 

The implemented setting file is the following:
```xml
<settings>
	<attributes>
		<key>LOCALHOST_SSH</key>		<nagios_cgi_query>http://ska-tm1.ia2.inaf.it/nagios/cgi-bin/statusjson.cgi?query=service&amp;hostname=localhost&amp;servicedescription=SSH</nagios_cgi_query>
		<json_query_result>data/service/plugin_output</json_query_result>
	</attributes>
</settings>
```

Commands available:
* public String CheckService(String[] checkServiceIn)
* string[] ServiceList() 
* String[] HostList()

This prototype is a *proof of concept*. 