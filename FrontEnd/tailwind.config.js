/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
    "node_modules/flowbite-react/lib/esm/**/*.js",
  ],
  theme: {
    extend: {
      colors: {
        blue: "#3A5BF0",
        yellow: "#FFDD3E",
        whiteblue: "#F5F7FE",
        lightgray: "#D9D9D9",
        gray: "#999999",
        darkgray: "#666666",
      },
      screens: {
        mobile: "281px",
        tablet: "640px",
        laptop: "1024px",
        desktop: "1280px",
      },
    },
  },
  plugins: [require("tailwind-scrollbar-hide"), require("flowbite/plugin")],
};
