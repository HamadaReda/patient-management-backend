package com.pm.patientservice.controller;

import com.pm.patientservice.common.ApiResponse;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PatientResponseDTO>>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        ApiResponse<List<PatientResponseDTO>> response = ApiResponse.success(HttpStatus.OK.value(), "Patients fetched successfully", patients);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponseDTO>> getPatient(@PathVariable UUID id){
        PatientResponseDTO patientResponseDTO = patientService.getPatient(id);
        ApiResponse<PatientResponseDTO> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Patient fetched successfully",
                patientResponseDTO
        );
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PatientResponseDTO>> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patientResponseDTO.getId()).toUri();
        ApiResponse<PatientResponseDTO> response = ApiResponse.success(HttpStatus.CREATED.value(), "Patient created successfully", patientResponseDTO);
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponseDTO>> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
        ApiResponse<PatientResponseDTO> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Patient updated successfully",
                patientResponseDTO
        );
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponseDTO>> deletePatient(@PathVariable UUID id){
        PatientResponseDTO patientResponseDTO = patientService.deletePatient(id);
        ApiResponse<PatientResponseDTO> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Patient deleted successfully",
                patientResponseDTO
        );
        return ResponseEntity.ok().body(response);
    }

}
