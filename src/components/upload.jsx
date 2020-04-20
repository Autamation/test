import React, { Component } from "react";
import axios from "axios";
import Select from "react-select";
import {
  MDBContainer,
  MDBBtn,
  MDBCard,
  MDBCardHeader,
  MDBCardBody,
} from "mdbreact";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const initialState = {
  warehouseCode: "",
  warehouseFile: null,
  orderFile: null,
  startDate: "",
  endDate: "",
  warehouseCodeError: "",
  warehouseFileError: "",
  orderFileError: "",
  dateError: "",
};
class Upload extends Component {
  getPickerValue = (value) => {
    console.log(value);
  };

  state = initialState;

  componentDidMount() {
    this.getWarehouseCode();
  }

  toggle = () => {
    this.setState({
      modal: !this.state.modal,
    });
  };
  handleCodeChange = (event) => {
    this.setState({
      warehouseCode: event.target.value,
    });
  };

  handleWarehouseFileChange = (event) => {
    this.setState({
      warehouseFile: event.target.files[0],
    });
  };
  validateWarehouse = () => {
    if (!this.state.warehouseFile === null) {
      this.setState({
        warehouseFileError: "file is not selected",
      });
      return false;
    }
    if (!this.state.warehouseCode) {
      this.setState({
        warehouseCodeError: "warehouse Code is mandatory",
      });
      return false;
    }

    return true;
  };
  resetWarehouse = (event) => {
    this.setState({
      warehouseCode: "",
      warehouseFile: null,
      warehouseCodeError: "",
      warehouseFileError: "",
    });
  };

  handleWarehouseSubmit = (event) => {
    event.preventDefault();
    const isValid = this.validateWarehouse();
    if (isValid) {
      // clear form
      this.uploadWarehouseFile();
      this.resetWarehouse();
      this.toggle();
    }
  };
  async uploadWarehouseFile() {
    let url = "dalrada/upload/warehouse";

    const formData = new FormData();
    formData.set("id", this.state.warehouseCode);
    formData.append("file", this.state.warehouseFile);

    let token = JSON.parse(localStorage.getItem("token"));
    if (token != null) {
      const headers = { Authorization: "Bearer " + token.uuid };
      console.log(this.state.warehouseFile);
      axios
        .post(url, formData, { headers })
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    }
  }

  handleChange = (selectedOption) => {
    this.setState({ warehouseCode: selectedOption });
  };

  async getWarehouseCode() {
    console.log("getWarehouseId called");
    const url = "dalrada/warehouse/warehouses";
    let token = JSON.parse(localStorage.getItem("token"));
    if (token != null) {
      const headers = { Authorization: "Bearer " + token.uuid };
      axios
        .get(url, { headers })
        .then((response) => {
          console.log(response);
          const warehouseCodes = response.data
            .filter((item) => item.respBody.status === 1)
            .map((resp) => {
              return {
                value: resp.respBody.warehouseCode,
                label: resp.respBody.warehouseCode,
              };
            });

          this.setState({
            warehouseIdItems: warehouseCodes,
          });
        })
        .catch((error) => console.log(error));
    }
  }

  handleStartDate = (date) => {
    this.setState({
      startDate: date,
    });
  };

  handleEndDate = (date) => {
    this.setState({
      endDate: date,
    });
  };

  handleOrderFileChange = (event) => {
    this.setState({
      orderFile: event.target.files[0],
    });
  };

  validateOrders = () => {
    const from = this.state.startDate;
    const to = this.state.endDate;

    if (!this.state.orderFile === null) {
      this.setState({
        orderFileError: "file is not selected",
      });
      return false;
    }
    if (!from) {
      this.setState({
        dateError: "Enter the Start DATE",
      });
      return false;
    }
    if (!to) {
      this.setState({
        dateError: "Enter the END DATE",
      });
      return false;
    }
    return true;
  };
  resetOrder = (event) => {
    this.setState({
      orderFile: null,
      startDate: "",
      endDate: "",
      orderFileError: "",
      dateError: "",
    });
  };

  handleOrderSubmit = (event) => {
    event.preventDefault();
    const isValid = this.validateOrders();
    if (isValid) {
      // clear form
      this.uploadOrderFile();
      this.resetOrder();
    }
  };

  async uploadOrderFile() {
    let url = "dalrada/upload/orders";
    const formData = new FormData();
    formData.set("startDate", this.state.startDate.toISOString().split("T")[0]);
    formData.set("endDate", this.state.endDate.toISOString().split("T")[0]);
    formData.append("file", this.state.orderFile);

    let token = JSON.parse(localStorage.getItem("token"));
    if (token != null) {
      const headers = { Authorization: "Bearer " + token.uuid };

      console.log(this.state.startDate.toISOString().split("T"));
      console.log(this.state.startDate.toISOString().split(" "));
      axios
        .post(url, formData, { headers })
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    }
  }

  render() {
    const today = new Date();
    return (
      <MDBContainer>
        <div className="row">
          <div className="col-xl-6 col-sm-12">
            <MDBCard>
              <MDBCardHeader
                titleClass="d-inline title"
                color="cyan darken-3"
                className="text-center darken-3 white-text"
              >
                Warehouse
              </MDBCardHeader>
              <MDBCardBody>
                <form onSubmit={this.handleWarehouseSubmit}>
                  <div className="input-group ">
                    <div className="input-group-prepend">
                      <span
                        className="input-group-text"
                        id="inputGroupFileAddon01"
                      >
                        Upload
                      </span>
                    </div>
                    <div className="custom-file">
                      <input
                        type="file"
                        accept=".csv , .CSV"
                        className="custom-file-input"
                        id="inputGroupFile01"
                        aria-describedby="inputGroupFileAddon01"
                        onChange={this.handleWarehouseFileChange}
                      />
                      <label
                        className="custom-file-label"
                        htmlFor="inputGroupFile01"
                      >
                        Choose warehouse file
                      </label>
                    </div>
                  </div>
                  <div className="text-center red-text">
                    {this.state.warehouseFileError}
                  </div>
                  <Select
                    className="mt-5"
                    value={this.state.warehouseCode}
                    onChange={this.handleChange}
                    options={this.state.warehouseIdItems}
                  />
                  <div className="text-center red-text">
                    {this.state.warehouseCodeError}
                  </div>
                  <div className="text-center mt-3 ">
                    <MDBBtn
                      color="danger"
                      className="mb-2 mt-3 rounded-pill"
                      outline
                      type="submit"
                      onClick={this.toggle}
                    >
                      Upload
                    </MDBBtn>
                    <MDBBtn
                      color="primary"
                      className="mb-2 mt-3 rounded-pill"
                      outline
                      onClick={this.resetWarehouse}
                    >
                      Reset
                    </MDBBtn>
                  </div>
                </form>
              </MDBCardBody>
            </MDBCard>
          </div>
          <div className="col-xl-6 col-sm-12 mt-xs-5">
            <MDBCard>
              <MDBCardHeader
                titleClass="d-inline title"
                color="cyan darken-3"
                className="text-center darken-3 white-text"
              >
                Order
              </MDBCardHeader>
              <MDBCardBody>
                <form onSubmit={this.handleOrderSubmit}>
                  <div className="input-group mt-1">
                    <div className="input-group-prepend">
                      <span
                        className="input-group-text"
                        id="inputGroupFileAddon02"
                      >
                        Upload
                      </span>
                    </div>
                    <div className="custom-file">
                      <input
                        type="file"
                        accept=".csv , .CSV"
                        className="custom-file-input"
                        id="inputGroupFile02"
                        aria-describedby="inputGroupFileAddon02"
                        onChange={this.handleOrderFileChange}
                      />
                      <label
                        className="custom-file-label"
                        htmlFor="inputGroupFile02"
                      >
                        Choose order file
                      </label>
                    </div>
                  </div>
                  <div className="text-center red-text">
                    {this.state.orderFileError}
                  </div>
                  <div className="row mt-3">
                    <span className="col-3">Start Date</span>
                    <DatePicker
                      className="mr-4 col-8"
                      selected={this.state.startDate}
                      value={this.state.startDate}
                      maxDate={today}
                      type="date"
                      onChange={this.handleStartDate}
                    />
                  </div>
                  <div className="row mt-3">
                    <span className="col-3">End Date</span>
                    <DatePicker
                      className="mr-4 col-8"
                      selected={this.state.endDate}
                      value={this.state.endDate}
                      maxDate={today}
                      minDate={this.state.startDate}
                      type="date"
                      onChange={this.handleEndDate}
                    />
                  </div>
                  <div className="text-center red-text">
                    {this.state.dateError}
                  </div>
                  <div className="text-center mt-2">
                    <MDBBtn
                      color="danger"
                      className="mb-2 mt-3 rounded-pill"
                      outline
                      type="submit"
                    >
                      Upload
                    </MDBBtn>
                    <MDBBtn
                      color="primary"
                      className="mb-2 mt-3 rounded-pill"
                      outline
                      onClick={this.resetOrder}
                    >
                      Reset
                    </MDBBtn>
                  </div>
                </form>
              </MDBCardBody>
            </MDBCard>
          </div>
        </div>
      </MDBContainer>
    );
  }
}

export default Upload;
