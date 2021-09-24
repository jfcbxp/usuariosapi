package com.dbasuporte.usuariosapi.validation;

import org.springframework.beans.factory.annotation.Configurable;

import com.dbasuporte.usuariosapi.services.exceptions.DocumentoInvalidoException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class DocumentoValidador implements ConstraintValidator<DocumentoValido, byte[]> {
	private int maxUploadSizeInKb = 2 * 1024;

	/*
	 * Utilizo o conceito de MagicBytes para identificar se o arquivo enviado é pdf
	 */
	@Override
	public boolean isValid(byte[] value, ConstraintValidatorContext context) {

		if (value != null) {

			InputStream targetStream = new ByteArrayInputStream(value);

			int fileSizeInKb = (value.length / 1024);
			if (fileSizeInKb > maxUploadSizeInKb) {
				throw new DocumentoInvalidoException();
			}

			try {
				if (MagicBytes.PDF.is(targetStream)) {
					return true;
				}
			} catch (IOException e) {
				throw new DocumentoInvalidoException();

			}

		}
		throw new DocumentoInvalidoException();
	}
}