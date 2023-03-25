package systems.nolasco.portafolio.resourceserverdemo.model.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(NON_NULL)
public class ProductResponse {
	private int status;
	private Map<?, ?> data;
}
