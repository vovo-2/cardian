import type { CustomFlowbiteTheme } from "flowbite-react";

export const CategoryTheme: CustomFlowbiteTheme["dropdown"] = {
    arrowIcon: "ml-2 h-4 w-4",
    content: "py-1 focus:outline-none",
    floating: {
      animation: "transition-opacity",
      arrow: {
        base: "absolute z-10 h-2 w-2 rotate-45",
        style: {
          dark: "bg-gray dark:bg-gray",
          light: "bg-white",
          auto: "bg-white dark:bg-gray",
        },
        placement: "-4px",
      },
      base: "z-10 w-fit rounded divide-y divide-gray shadow focus:outline-none",
      content: "py-1 text-sm text-gray dark:text-gray-200",
      divider: "my-1 h-px bg-gray dark:bg-gray",
      header: "block py-2 px-4 text-sm text-gray dark:text-gray-200",
      hidden: "invisible opacity-0",
      item: {
        container: "",
        base: "flex items-center justify-center py-2 px-4 w-[150px] text-sm text-black cursor-pointer hover:text-blue  focus:outline-none ",
        icon: "mr-2 h-4 w-4",
      },
      style: {
        dark: "bg-gray text-white dark:bg-gray",
        light: "border border-gray-200 bg-white text-gray",
        auto: "border border-gray-200 bg-white text-gray dark:border-none dark:bg-gray dark:text-white",
      },
      target: "w-fit",
    },
    inlineWrapper: "flex items-center",
};