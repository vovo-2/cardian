import { CustomFlowbiteTheme } from "flowbite-react";

export const AccordionTheme: CustomFlowbiteTheme = {
  accordion: {
    root: {
      base: "border-none",
      flush: {
        off: "",
        on: "",
      },
    },
    content: {
      base: "border-2 rounded-xl border-whiteblue mt-3 p-3",
    },
    title: {
      arrow: {
        base: "my-auto text-xl",
        open: {
          off: "text-blue",
          on: "rotate-180 text-gray",
        },
      },
      base: "bg-whiteblue p-4 w-full rounded-2xl mt-2 flex",
      flush: {
        off: "",
        on: "",
      },
      heading: "w-full",
      open: {
        off: "",
        on: "",
      },
    },
  },
};
