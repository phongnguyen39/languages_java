package com.phong.mvc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.phong.mvc.models.Language;
import com.phong.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {

    // adding the language repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository= languageRepository;
    }
    
    // returns all the languagess
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    
    // RETRIEVES A LANGUAGE BY ID
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    // UPDATES THE LANGUAGE
    public Language updateLanguage(Language b) {
        return languageRepository.save(b);
    }
	
    
    // UPDATES THE LANGUAGE
    // EXPLAINATION OF LOGIC:  IT IS A METHOD WITH PARAMETERS OF ID, TITLE, DESC, LANG & # OF PAGES.
    // instantiates an optional langauge list.   A bunch of conditionals to see if the data exist.  If yes then it returns
    
	public Language updateLanguage(Long id, String langName, String creator, String currentVersion) {
		// TODO Auto-generated method stub
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			optionalLanguage.get().setlanguageName(langName);
			optionalLanguage.get().setcreator(creator);
			optionalLanguage.get().setcurrentVersion(currentVersion);
			
			return optionalLanguage.get();
		}
		return null;
	}
	
   // DELETES A LANGUAGE
	public void deleteLanguage(Long id) {
		// TODO Auto-generated method stub
		languageRepository.deleteById(id);
	}
}
