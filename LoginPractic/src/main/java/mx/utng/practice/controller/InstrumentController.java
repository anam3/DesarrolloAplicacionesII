package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Instrument;
import mx.utng.practice.repository.InstrumentRepository;

@Named
@ViewScoped
public class InstrumentController {
	@Autowired
	private InstrumentRepository instrumentRepository;
	private Instrument instrument = new Instrument();
	private List<Instrument> instruments;
	
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setInstruments(instrumentRepository.findAll());
	}
	
	public void save(){
		instrumentRepository.save(instrument);
		if(!editMode){
			getInstruments().add(instrument);
		}
		instrument=new Instrument();
		setEditMode(false);
	}
	
	public void delete(Instrument instrument){
		instrumentRepository.delete(instrument);
		instruments.remove(instrument);
	}
	
	public void update(Instrument instrument){
		setInstrument(instrument);
		setEditMode(true);
	}
	
	public void cancel(){
		instrument = new Instrument();
		setEditMode(false);
	}
	
	public InstrumentRepository getInstrumentRepository() {
		return instrumentRepository;
	}

	public void setInstrumentRepository(InstrumentRepository instrumentRepository) {
		this.instrumentRepository = instrumentRepository;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
