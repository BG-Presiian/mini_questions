import React from 'react';
import { Route, Navigate } from "react-router-dom";

const Container = ({Component, redirectLink, isAuthenticated, ...props}) => {
    if(!isAuthenticated) {
         return <Navigate to={redirectLink} />;
     }
     return <Component {...props} />
  }

  const GuardedRoute = ({ component: Component, redirectLink, isAuthenticated, path, ...props }) => {   
    return (
      <Route
          path={path}
          element={
            <Container redirectLink={redirectLink} 
                       isAuthenticate={isAuthenticated} 
                       Component={Component} 
            />}
      />
  )}

  export default GuardedRoute;