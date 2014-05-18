package spring.boot.example.wicket.services;

import org.springframework.stereotype.Service;

/**
 * sample spring service to show / test integration
 * 
 * @author kloe
 * 
 */
@Service
public class TextService {

	public String getText() {
		return "delivered by spring service";
	}

}
