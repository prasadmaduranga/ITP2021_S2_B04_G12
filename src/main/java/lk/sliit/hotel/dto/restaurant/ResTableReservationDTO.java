package lk.sliit.hotel.dto.restaurant;

import java.util.List;

public class ResTableReservationDTO {

    int reseId;
    String type;
    String state;
    String button;
    List<ResTableDTO> tables;
    int index;

    public ResTableReservationDTO() {
    }

    public ResTableReservationDTO(int reseId, String type, String state, String button, List<ResTableDTO> tables, int index) {
        this.reseId = reseId;
        this.type = type;
        this.state = state;
        this.button = button;
        this.tables = tables;
        this.index = index;
    }

    public int getReseId() {
        return reseId;
    }

    public void setReseId(int reseId) {
        this.reseId = reseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public List<ResTableDTO> getTables() {
        return tables;
    }

    public void setTables(List<ResTableDTO> tables) {
        this.tables = tables;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
