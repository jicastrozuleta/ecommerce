package co.com.application.ecommerce.service;

import co.com.application.ecommerce.dto.CodeDTO;
import co.com.application.ecommerce.model.Code;

public interface ICodeService {

	public Code validateCode(CodeDTO code);

	public Code addCode(Code code);

	public void deleteCode(Code code);

}
