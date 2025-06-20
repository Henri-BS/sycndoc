import { CustomFlowbiteTheme, List, ListItem } from "flowbite-react";
import Markdown from "react-markdown";

export const customTheme: CustomFlowbiteTheme = {
    carousel: {
        root: {
            base: "relative h-full w-full",
            leftControl: "absolute left-0 top-0 flex h-full items-center justify-center px-4 focus:outline-none",
            rightControl: "absolute right-0 top-0 flex h-full items-center justify-center px-4 focus:outline-none"
        },
        indicators: {
            active: {
                off: "bg-gray-400/70 hover:bg-gray-500",
                on: "bg-gray-500"
            },
            base: "h-3 w-3 rounded-full",
            wrapper: "absolute bottom-5 left-1/2 flex -translate-x-1/2 space-x-3"
        },
        control: {
            base: "inline-flex h-8 w-8 items-center justify-center rounded-full group-focus:outline-none group-focus:ring-4 group-focus:ring-white bg-gray-800/50 group-hover:bg-gray-800/80 group-focus:ring-gray-800/80 sm:h-10 sm:w-10",
            icon: "h-5 w-5 text-white sm:h-6 sm:w-6"
        },
    },

    navbar: {
        "link": {
            "base": "block py-2 pl-3 pr-4 md:p-0 transition duration-300",
            "active": {
                "on": "bg-primary-700 text-white md:bg-transparent md:text-primary-700 dark:text-white",
                "off": "border-b border-gray-100 text-gray-200 hover:text-yellow-400 hover:bg-gray-800/50 md:border-b-2 md:border-[transparent] md:hover:border-yellow-400 md:hover:bg-transparent"
            },
            "disabled": {
                "on": "text-gray-400 hover:cursor-not-allowed dark:text-gray-600",
                "off": ""
            }
        },
        "toggle": {
            "base": "inline-flex items-center rounded-lg p-2 text-sm text-gray-500 hover:bg-gray-800 focus:outline-none focus:ring-2 focus:ring-gray-200 md:hidden dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600",
            "icon": "h-6 w-6 shrink-0 text-yellow-400",
        }
    },
    button: {
        "color": {
            "yellow": "text-yellow-400 hover:text-white border border-yellow-500 hover:bg-yellow-500 focus:ring-4 focus:outline-none focus:ring-yellow-300 font-medium rounded-lg text-sm text-center"
        },
    },
    dropdown: {
        "content": " focus:outline-none ",
        "floating": {
            "item": {
                "container": "",
                "base": "flex w-full cursor-pointer items-center justify-start px-4 py-2 text-md focus:outline-none text-zinc-200 bg-zinc-800 hover:bg-zinc-600 hover:text-white focus:text-white",
                "icon": "mr-2 h-4 w-4"
            },
        }
    },
    floatingLabel: {
        "input": {
            "default": {
                "filled": {
                    "sm": "peer block w-full appearance-none rounded-t-lg border-0 border-b-2 border-gray-300 bg-gray-50 px-2.5 pb-2.5 pt-5 text-xs text-gray-900 focus:border-primary-600 focus:outline-none focus:ring-0 dark:border-gray-600 dark:bg-gray-700 dark:text-white dark:focus:border-primary-500",
                    "md": "peer block w-full appearance-none rounded-t-lg border-0 border-b-2 border-gray-300 bg-gray-50 px-2.5 pb-2.5 pt-5 text-sm text-gray-900 focus:border-primary-600 focus:outline-none focus:ring-0 dark:border-gray-600 dark:bg-gray-700 dark:text-white dark:focus:border-primary-500"
                },
            }
        },
        "label": {
            "default": {
                "filled": {
                    "sm": "absolute left-2.5 top-2 z-10 origin-[0] -translate-y-4 scale-75 text-xs text-gray-500 transition-transform duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:-translate-y-4 peer-focus:scale-75 peer-focus:text-primary-600 ",
                    "md": "absolute left-2.5 top-2 z-10 origin-[0] -translate-y-4 scale-75 text-sm text-gray-500 transition-transform duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:-translate-y-4 peer-focus:scale-75 peer-focus:text-primary-600 "
                },
            },
        }
    },
};


export const CustomMarkdown = ({ item }: any) => {
    const CustomParagraph = ({ children }: any) => (
        <p className="text-gray-800 leading-relaxed mb-4">
            {children}
        </p>
    );

    const CustomH1 = ({ children }: any) => (
        <h1 className="text-3xl font-semibold mt-4 mb-2">{children}</h1>
    );

    const CustomH2 = ({ children }: any) => (
        <h2 className="text-2xl font-semibold mt-4 mb-2">{children}</h2>
    );

    const CustomH3 = ({ children }: any) => (
        <h3 className="text-xl font-semibold mt-4 mb-2">{children}<hr /></h3>
    );

    const CustomList = ({ children }: any) => (
        <List className="text-gray-700">
            <List.Item>{children}</List.Item>
        </List>
    );

    const CustomOrderedList = ({ children }: any) => (
        <List className="text-gray-700" ordered>
            <List.Item>{children}</List.Item>
        </List>
    );

    return (
        <Markdown components={{
            p: CustomParagraph,
            h1: CustomH1,
            h2: CustomH2,
            h3: CustomH3,
            li: CustomList,
            ol: CustomOrderedList
        }}
        >
            {item}
        </Markdown>
    );
}

