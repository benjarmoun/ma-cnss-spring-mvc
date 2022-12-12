<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 06/12/2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x-on" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Dossier</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <script defer src="https://unpkg.com/@alpinejs/persist@3.x.x/dist/cdn.min.js"></script>
</head>
<body>
<!-- component -->
    <main class="flex min-h-screen flex-col justify-center bg-cyan-500 p-16">
    <h1 class="text-3xl font-bold text-white">Input designs</h1>
    <p class="mb-8 font-semibold text-gray-100">Created by Gezellligheid</p>
    <div class="w-full rounded-xl bg-white p-4 shadow-2xl shadow-white/40">
        <form modelAttribute="dossier" action="AddDossier" method="post">

            <div class="mb-4 flex flex-col">
                <label for="patientId" class="mb-2 font-semibold">Client Matricul</label>
                <div class="relative">
                    <input type="text" id="patientId" path="patientId" name="patientId" class="w-full rounded-lg border border-slate-200 px-2 py-1 pl-8 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40" />
                </div>
            </div>

            <div class="mb-4 grid grid-cols-2 gap-4">
                <div class="flex flex-col" x-data="{count: 1}">
                    <label for="speciality" class="mb-2 font-semibold">Speciality :</label>
                    <template x-for="i in count">
                        <select :name="'speciality'+i" id="speciality" class="w-full mb-2 max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40">
                            <c:forEach items="${specialities}" var="spec">
                                <option value="${spec.id}">${spec.name}</option>
                            </c:forEach>
                        </select>
                    </template>
                    <button type="button" x-on:click="count++" >
                        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd"></path></svg>
                    </button>
                    <input type="text" :value="count" name="spec_number" hidden>
                </div>
                <div class="flex flex-col" x-data="{count: 0}">
                    <label for="medication" class="mb-2 font-semibold">Medication :</label>
                    <template x-for="i in count">
                        <select :name="'medication'+i" id="medication" class="w-full mb-2 max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40">
                            <c:forEach items="${medications}" var="med">
                                <option value="${med.id}">${med.name}</option>
                            </c:forEach>
                        </select>
                    </template>
                    <button type="button" x-on:click="count++" >
                        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd"></path></svg>
                    </button>
                    <input type="text" :value="count" name="med_number" hidden>
                </div>
            </div>
            <div class="mb-4 grid grid-cols-2 gap-4">
                <div class="flex flex-col" x-data="{count: 0}">
                    <label for="radio" class="mb-2 font-semibold">Radio :</label>
                    <template x-for="i in count">
                        <select :name="'radio'+i" id="radio" class="w-full mb-2 max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40">
                            <c:forEach items="${radios}" var="rad">
                                <option value="${rad.id}">${rad.name}</option>
                            </c:forEach>
                        </select>
                    </template>
                    <button type="button" x-on:click="count++" >
                        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd"></path></svg>
                    </button>
                    <input type="text" :value="count" name="rad_number" hidden>
                </div>
                <div class="flex flex-col" x-data="{count: 0}">
                    <label for="analysis" class="mb-2 font-semibold">Analysis :</label>
                    <template x-for="i in count">
                        <select :name="'analysis'+i" id="analysis" class="w-full mb-2 max-w-lg rounded-lg border border-slate-200 px-2 py-1 hover:border-blue-500 focus:outline-none focus:ring focus:ring-blue-500/40 active:ring active:ring-blue-500/40">
                            <c:forEach items="${analysis}" var="analy">
                                <option value="${analy.id}">${analy.name}</option>
                            </c:forEach>
                        </select>
                    </template>
                    <button type="button" x-on:click="count++" >
                        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd"></path></svg>
                    </button>
                    <input type="text" :value="count" name="analy_number" hidden>
                </div>
            </div>

            <button type="submit"> submit </button>
        </form>
    </div>
</main>
</body>
</html>
