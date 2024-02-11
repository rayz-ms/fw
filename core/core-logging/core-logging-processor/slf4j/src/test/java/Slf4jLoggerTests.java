import com.ggar.core.logging.domain.*;
import com.ggar.core.logging.processor.LogLevels;
import com.ggar.core.logging.processor.Slf4jLogger;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;

public class Slf4jLoggerTests {

	@Test
	public void test() {
		FindByLogMessagePort findByLogMessage = logRequest -> Optional.of(ImmutableLog.builder())
			.map(builder -> builder
				.logId(ImmutableLogId.builder()
					.application(() -> "app1")
					.subsystem(() -> "subs1")
					.id(1L)
					.logLevel(LogLevels.E)
					.build()
				)
				.message("hola que ase")
				.charset(StandardCharsets.UTF_8)
				.locale(Locale.forLanguageTag("es-ES"))
			)
			.map(ImmutableLog.Builder::build);
		Slf4jLogger logger = new Slf4jLogger(findByLogMessage);
		logger.process(ImmutableLogRequest.of(() -> "app1", () -> "sub2", LogLevels.E, 1L));
	}

}
