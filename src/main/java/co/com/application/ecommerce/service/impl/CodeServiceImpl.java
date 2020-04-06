package co.com.application.ecommerce.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.application.ecommerce.Utils;
import co.com.application.ecommerce.dto.CodeDTO;
import co.com.application.ecommerce.model.Code;
import co.com.application.ecommerce.repository.CodeRepository;
import co.com.application.ecommerce.service.ICodeService;

@Service
public class CodeServiceImpl implements ICodeService {

	@Autowired
	private CodeRepository codeRepository;

	@Override
	public Code validateCode(CodeDTO code) {
		Optional<Code> opt = codeRepository.validateCode(code.getUsername(), code.getIdUsuario(), code.getCodeNumber());
		if (opt.isPresent() && (new Date()).before(code.getExpiration())) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public Code addCode(Code code) {
		code.setExpiration(Utils.expirationTime());
		code.setCodeNumber(Utils.generateNumber());
		codeRepository.removeOthers(code.getUsername());
		return codeRepository.saveAndFlush(code);
	}

	@Override
	public void deleteCode(Code code) {
		codeRepository.delete(code);
	}
}
