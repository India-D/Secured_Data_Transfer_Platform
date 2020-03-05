import React from "react";
import { Form, Button } from "react-bootstrap";
import { Formik } from "formik";
import test from "./SignUpForm.style";
import axios from "axios";

function SignUp() {
  //const axios = require('axios').default;
  return (
    //Formik component
    <Formik
      //initial values for user
      initialValues={{ email: "", password: "" }}
      //check errors
      validate={values => {
        const errors = {};
        if (!values.email) {
          errors.email = <h3>Required</h3>;
        } else if (
          !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
        ) {
          errors.email = "Invalid email address";
        }
        if (!values.password) {
          errors.password = <h3>Required"</h3>;
        } else if (
          !/^.*(?=.{8,20})((?=.*[!@#$%^&*()\-_=+{};:,<.>]){1})(?=.*\d)((?=.*[a-z]){1})((?=.*[A-Z]){1}).*$/g.test(
            values.password
          )
        ) {
          errors.password = "Invalid password";
        }

        return errors;
      }}
      onSubmit={(values, { setSubmitting }) => {
        //Declare une const URL_BASE = "http://localhost:9090"
        setTimeout(() => {
          axios({
            method: "post",
            //url: URL_BASE + "/members"
            url: "http://localhost:9090/members/",
            data: {
              username: values.email,
              password: values.password
            }
          })
            .then(function response() {
              console.log(response);
            })
            .catch(function error() {
              console.log(error);
            });
          // alert(JSON.stringify(values, null, 2), "hello");
          setSubmitting(false);
        }, 400);
      }}
    >
      {({
        values,
        errors,
        touched,
        handleChange,
        handleBlur,
        handleSubmit,
        isSubmitting
        /* and other goodies */
      }) => (
        <Form style={test} onSubmit={handleSubmit}>
          <Form.Group controlId="formBasicEmail">
            <h1>Création de compte</h1>
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              name="email"
              value={values.email}
              onBlur={handleBlur}
              onChange={handleChange}
              placeholder="Enter email"
            />
            {errors.email && touched.email && errors.email}
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
            </Form.Text>
          </Form.Group>

          <Form.Group controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              placeholder="Password"
              name="password"
              onChange={handleChange}
              onBlur={handleBlur}
              value={values.password}
            />
            {errors.password && touched.password && errors.password}
          </Form.Group>
          <Form.Group controlId="formBasicCheckbox">
            <Form.Check type="checkbox" label="Check me out" />
          </Form.Group>
          <Button variant="primary" type="submit" disabled={isSubmitting}>
            Submit
          </Button>
        </Form>
      )}
    </Formik>
  );
}

export default SignUp;
