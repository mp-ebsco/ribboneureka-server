package ribboneureka.server.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
//import org.coursera.metrics.datadog.DatadogReporter;
//import org.coursera.metrics.datadog.transport.UdpTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableMetrics(proxyTargetClass = true)
public class MetricsConfig extends MetricsConfigurerAdapter {

	@Value("${metric.polling.duration:1}")
	private String metricPollingDuration; 
	
	@Override
	public void configureReporters(MetricRegistry metricRegistry) {
		// registerReporter allows the MetricsConfigurerAdapter to
		// shut down the reporter when the Spring context is closed

		registerReporter(ConsoleReporter.forRegistry(metricRegistry).build()).start(Long.parseLong(metricPollingDuration), TimeUnit.MINUTES);

//		registerReporter(
//				DatadogReporter.forRegistry(metricRegistry).withTransport(new UdpTransport.Builder().build()).build())
//						.start(10, TimeUnit.SECONDS);
	}

}
