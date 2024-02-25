import org.junit.jupiter.api.Test;

public class Slf4jLoggerTests {

	@Test
	public void test() {

//		FindByLogMessagePort findByLogMessage = logRequest -> Optional.of(ImmutableLog.builder())
//			.map(builder -> builder
//				.logId(ImmutableLogId.builder()
//					.application(() -> "app1")
//					.subsystem(() -> "subs1")
//					.id(1L)
//					.logLevel(LogLevels.E)
//					.build()
//				)
//				.message("hola que ase")
//				.charset(StandardCharsets.UTF_8)
//				.locale(Locale.forLanguageTag("es-ES"))
//			)
//			.map(ImmutableLog.Builder::build);
//		Slf4jLogger logger = new Slf4jLogger(findByLogMessage);
//		logger.process(ImmutableLogRequest.of(() -> "app1", () -> "sub2", LogLevels.E, 1L));

//		@Value.Parameter(order = 1)
//		Application application();
//		@Value.Parameter(order = 2)
//		Subsystem subsystem();
//		@Value.Parameter(order = 3)
//		LogLevel logLevel();
//		@Value.Parameter(order = 4)
//		Long id();
	}

}
