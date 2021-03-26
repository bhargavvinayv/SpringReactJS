import React, { Component } from "react";
import axios from "axios";

class Update extends Component {
  state = {
    quantity: "",
    pid: "",
  };
  constructor(props) {
    super(props);
    this.uhandleSubmit = this.uhandleSubmit.bind(this);
    this.dhandleSubmit = this.dhandleSubmit.bind(this);
    this.uhandle = this.uhandle.bind(this);
  }
  uhandle = event => {
    this.setState({ quantity: event.target.value });
  };
  uhandleSubmit = async event => {
    event.preventDefault();
    const id = this.props.pid;
    try {
      const res = await axios
        .put(`/updateProduct`, {
          pid: this.props.pid,
          title: this.props.pt,
          price: this.props.pp,
          quantity: this.props.pq - -this.state.quantity,
        })
        .then(res => {
          console.log(res);
        });
      console.log(this.state.quantity);
    } catch (err) {
      console.error(err);
    }
  };

  dhandleSubmit = event => {
    event.preventDefault();
    console.log(this.props.pid);
    const id = this.props.pid;

    axios.delete(`/deleteProduct/${id}`, (req, res) => {
      res.send("deleted");
    });
  };
  render() {
    return (
      <div className="row-sm-2">
        <div className="form-group">
          <form onSubmit={this.uhandleSubmit}>
            <input
              className="input"
              type="number"
              placeholder="0"
              min="0"
              onChange={this.uhandle}
            ></input>
            <button className="col btn btn-warning" type="submit">
              Update
            </button>
          </form>
          <form onSubmit={this.dhandleSubmit}>
            <button className="col btn btn-danger" type="submit">
              Delete
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default Update;
