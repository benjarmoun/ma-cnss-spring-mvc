<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 06/12/2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Dossier</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
</head>
<body>
<!-- component -->
    <main class="flex min-h-screen flex-col justify-center bg-cyan-500 p-16">
    <h1 class="text-3xl font-bold text-white">Input designs</h1>
    <p class="mb-8 font-semibold text-gray-100">Created by Gezellligheid</p>
    <div class="w-full rounded-xl bg-white p-4 shadow-2xl shadow-white/40">
        <div class="mb-4 flex flex-col">
            <label for="clientmat" class="mb-2 font-semibold">Client Matricul</label>
            <div class="relative">
                <input type="text" id="clientmat" class="w-full rounded-lg border border-slate-200 px-2 py-1 pl-8 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40" />
            </div>
        </div>

        <div class="mb-4 grid grid-cols-2 gap-4">
            <div class="flex flex-col">
                <label for="text" class="mb-2 font-semibold">Text input</label>
                <input type="text" id="text" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40" />
            </div>
            <div class="flex flex-col">
                <label for="text" class="mb-2 font-semibold">Speciality</label>
                <select name="speciality" id="speciality" class="w-full max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40">
                    <option value="speciality">speciality</option>
                </select>
            </div>
        </div>

        <div class="mb-4 flex flex-col">
            <label for="email" class="mb-2 font-semibold">Email address</label>
            <div class="relative">
                <svg xmlns="http://www.w3.org/2000/svg" class="absolute left-2 top-2 h-5 w-5 text-slate-400" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M14.243 5.757a6 6 0 10-.986 9.284 1 1 0 111.087 1.678A8 8 0 1118 10a3 3 0 01-4.8 2.401A4 4 0 1114 10a1 1 0 102 0c0-1.537-.586-3.07-1.757-4.243zM12 10a2 2 0 10-4 0 2 2 0 004 0z" clip-rule="evenodd" />
                </svg>
                <input type="email" id="text" class="w-full rounded-lg border border-slate-200 px-2 py-1 pl-8 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40" />
            </div>
        </div>
        <div class="mb-4 flex flex-col">
            <label for="age" class="mb-2 font-semibold">Number input</label>
            <input type="number" id="age" class="w-full max-w-[200px] rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40" />
        </div>
        <div class="flex">

            <label for="privacy" class="mb-2 ">
                <input type="checkbox" name="privcay" id="privacy" class="mr-2 peer w-0 h-0" />
                <h1 class="font-semibold">I have read and agreed the privacy policy</h1>
                <div class="w-6 h-6  items-center inline-block justify-center hover:border-blue-500 focus:ring transition-all focus:ring-blue-500/40 border border-slate-200 rounded-lg peer-checked:bg-blue-500 peer-checked:[&>svg]:block [&>svg]:hidden">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mx-auto text-white " viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
                    </svg>
                </div>
            </label>

            <div class="flex items-center">
                <div "peer"></div>
        </div>
    </div>
    </div>
</main>
</body>
</html>
