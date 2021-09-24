package com.dbasuporte.usuariosapi.validation;

import java.io.IOException;
import java.io.InputStream;

public enum MagicBytes {
	PNG(0x89, 0x50), JPG(0xFF, 0xD8), PDF(0x25, 0x50);

	private final int[] magicBytes;

	private MagicBytes(int... bytes) {
		magicBytes = bytes;
	}

	public boolean is(byte[] bytes) {
		if (bytes.length != magicBytes.length)
			return false;
		for (int i = 0; i < bytes.length; i++) {
			if (Byte.toUnsignedInt(bytes[i]) != magicBytes[i]) {
				return false;
			}

		}
		return true;
	}

	public static byte[] extract(InputStream is, int length) throws IOException {
		try (is) {
			byte[] buffer = new byte[length];
			is.read(buffer, 0, length);
			return buffer;
		}
	}

	public boolean is(InputStream is) throws IOException {
		return is(extract(is, magicBytes.length));
	}

}