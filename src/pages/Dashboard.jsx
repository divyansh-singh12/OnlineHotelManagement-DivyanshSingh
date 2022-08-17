import React from "react";
import Carousel from "react-bootstrap/Carousel";
import Header from "./Header";
import hotel1 from "../Images/hotel1.png";
import hotel2 from "../Images/hotel2.png";
import hotel3 from "../Images/hotel3.png";


const Dashboard = () => {
  return (
    <div>
      < Header />
      <div style={{ display: 'block' }}>

        <Carousel  >
          <Carousel.Item interval={1500}>
            <img
              className="d-block w-100 h-500"
              src={hotel1}
              alt=" One"
              min-height={"500px"}
            />

          </Carousel.Item>
          <Carousel.Item interval={500}>
            <img
              className="d-block w-100"
              src={hotel2}
              alt="Two"
            />

          </Carousel.Item>
          <Carousel.Item interval={500}>
            <img
              className="d-block w-100"
              src={hotel3}
              alt="Three"
            />

          </Carousel.Item>
        </Carousel>
      </div>
    </div>

  )
}

export default Dashboard;