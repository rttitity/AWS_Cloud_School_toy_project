import React, { Component } from "react";

export default class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-md navbar-dark bg-dark">
            <div>
              <a href="http://ecs-front-alb-506385164.ap-northeast-2.elb.amazonaws.com" className="navbar-brand">
                songminseok - jenkins
              </a>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}
