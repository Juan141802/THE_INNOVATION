package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.TheInnovatonProyect.appTheInnov.facade.IFileService;
import com.TheInnovatonProyect.appTheInnov.modelo.Sede;
import com.TheInnovatonProyect.appTheInnov.repository.SedeRepository;

@Service
public class FileServicedao implements IFileService {

	@Autowired
	public SedeRepository SedeRepository;

	private final Path rootFolder = Paths.get("uploads");

	@Override
	public void save(MultipartFile file) throws Exception {
		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));
	}

	@Override
	public Resource load(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(List<MultipartFile> files) throws Exception {
		for (MultipartFile file : files) {

			this.save(file);

			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {

						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Sede sede = new Sede();

						sede.setBar(cell.getStringCellValue());
						cell = celIterator.next();
						this.SedeRepository.save(sede);
					}
					System.out.println("");
				}
			} catch (Exception e) {
				e.getMessage();
			}

		}

	}

	public void leerExcel(String nombreArchivo) {

		try (FileInputStream file = new FileInputStream(new File(nombreArchivo))) {

			XSSFWorkbook libro = new XSSFWorkbook(file);

			XSSFSheet sheet = libro.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			Row row;

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				Iterator<Cell> celIterator = row.cellIterator();
				Cell cell;
				while (celIterator.hasNext()) {
					cell = celIterator.next();
					System.out.println(cell.getStringCellValue());
				}
				System.out.println("");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public Stream<Path> loadAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
