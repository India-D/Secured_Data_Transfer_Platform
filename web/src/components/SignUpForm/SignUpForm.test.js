import React from "react";
import SignUpForm from "./SignUpForm.component";
import { render, fireEvent } from "@testing-library/react";

describe("[Component] <SignUpForm/>", () => {
  it("renders SignUpForm Component correctly", () => {
    const { container } = render(<SignUpForm />);
    const email = container.querySelector('input[name="email"]');
    const password = container.querySelector('input[name="password"]');
    fireEvent.change(email, {
      target: {
        value: "mockemail"
      }
    });

    fireEvent.change(password, {
      target: {
        value: "mockpassword"
      }
    });
  });
});
