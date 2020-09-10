

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.wellsfargo.sector.services.SectorService;

@Profile("test")
@Configuration
public class ServiceTestConfiguration {
    @Bean
    @Primary
    public SectorService sectorService() {
        return Mockito.mock(SectorService.class);
    }
}
