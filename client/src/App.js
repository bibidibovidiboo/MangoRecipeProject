import React, { Component } from 'react';
import Header from './components/header/Header';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import Main from './components/sections/main/Main';
import Community from './components/sections/community/Community';
import Contact from './components/sections/contact/Contact';
import Recipe from './components/sections/recipe/Recipe';
import Recommand from './components/sections/recommand/Recommand';
import Restaurant from './components/sections/restaurant/Restaurant';
import MyRefriger from './components/sections/myRefriger/MyRefriger';
import SignUp from './components/signup/SignUp';
import Login from './components/login/Login'

function App() {
  return (
    <div>
      <Router>

        <Header />

        <Switch>
          <Route exact path="/" component={Main} />
          <Route exact path="/page/community" component={Community} />
          <Route exact path="/page/contact" component={Contact} />
          <Route exact path="/page/recipe" component={Recipe} />
          <Route exact path="/page/recommand" component={Recommand} />
          <Route exact path="/page/restaurant" component={Restaurant} />
          <Route exact path="/page/MyRefriger" component={MyRefriger} />
          <Route exact path="/page/SignUp" component={SignUp} />
          <Route exact path="/page/Login" component={Login} />
        </Switch>

      </Router>

    </div>
  );
}

export default App;
