package com.sgmtec.patientRecord.Mapper;

import com.sgmtec.patientRecord.dto.PatientDTO;
import com.sgmtec.patientRecord.entity.Exam;
import com.sgmtec.patientRecord.entity.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T16:54:19-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient toModel(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        if ( patientDTO.getBirthday() != null ) {
            patient.setBirthday( LocalDate.parse( patientDTO.getBirthday(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        patient.setId( patientDTO.getId() );
        patient.setFirtsName( patientDTO.getFirtsName() );
        patient.setLastName( patientDTO.getLastName() );
        patient.setCpf( patientDTO.getCpf() );
        patient.setPhone( patientDTO.getPhone() );
        List<Exam> list = patientDTO.getExam();
        if ( list != null ) {
            patient.setExam( new ArrayList<Exam>( list ) );
        }

        return patient;
    }

    @Override
    public PatientDTO toDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( patient.getId() );
        patientDTO.setFirtsName( patient.getFirtsName() );
        patientDTO.setLastName( patient.getLastName() );
        patientDTO.setCpf( patient.getCpf() );
        patientDTO.setPhone( patient.getPhone() );
        if ( patient.getBirthday() != null ) {
            patientDTO.setBirthday( DateTimeFormatter.ISO_LOCAL_DATE.format( patient.getBirthday() ) );
        }
        List<Exam> list = patient.getExam();
        if ( list != null ) {
            patientDTO.setExam( new ArrayList<Exam>( list ) );
        }

        return patientDTO;
    }
}
